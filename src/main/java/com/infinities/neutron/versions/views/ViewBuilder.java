/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.neutron.versions.views;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.infinities.api.openstack.commons.model.Link;
import com.infinities.neutron.resources.model.Resource;
import com.infinities.neutron.resources.model.Resources;
import com.infinities.neutron.versions.model.Version;
import com.infinities.neutron.versions.model.Versions;

public class ViewBuilder {

	private String baseUrl;


	public static ViewBuilder getViewBuilder(URI uri) {
		return new ViewBuilder(uri.toString());
	}

	private ViewBuilder(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Versions buildVersions(Map<String, Version> versions) throws URISyntaxException {
		List<Version> versionObjs = new ArrayList<Version>();

		for (Version version : versions.values()) {
			versionObjs.add(build(version));
		}

		Versions wrapper = new Versions(versionObjs);
		return wrapper;
	}

	public Version build(Version version) throws URISyntaxException {
		Version ret = new Version();
		ret.setId(version.getId());
		ret.setStatus(version.getStatus());
		ret.setLinks(buildLinks(version));
		return ret;
	}

	private String generateHref(String version) throws URISyntaxException {
		return osPathJoin(baseUrl, version);
	}

	private String osPathJoin(String... strings) {
		checkNotNull(strings);
		checkArgument(strings.length > 0);
		final CharMatcher joinCharMatcher = CharMatcher.is('/');
		return Joiner.on('/').join(Iterables.transform(Arrays.asList(strings), new Function<String, String>() {

			@Override
			public String apply(final String input) {
				return joinCharMatcher.trimFrom(input);
			}
		}));
	}

	private List<Link> buildLinks(Version version) throws URISyntaxException {
		String href = this.generateHref(version.getId());
		List<Link> links = new ArrayList<Link>(1);
		Link link = new Link();
		link.setRel("self");
		link.setHref(href);
		links.add(link);

		return links;
	}

	public Resources buildResources(Version version) throws CloneNotSupportedException {
		Version reval = version.clone();
		List<Resource> resources = reval.getResources();
		for (Resource resource : resources) {
			Link link = new Link();
			link.setRel("self");
			String path = baseUrl.replaceAll("/+$", "") + "/";
			link.setHref(path);
			resource.getLinks().add(0, link);
		}
		return new Resources(resources);
	}
}
