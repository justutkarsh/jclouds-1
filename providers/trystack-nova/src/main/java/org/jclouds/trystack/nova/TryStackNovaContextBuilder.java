/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.trystack.nova;

import java.util.List;

import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.openstack.nova.v1_1.NovaApiMetadata;
import org.jclouds.openstack.nova.v1_1.NovaAsyncClient;
import org.jclouds.openstack.nova.v1_1.NovaClient;
import org.jclouds.openstack.nova.v1_1.NovaContextBuilder;
import org.jclouds.providers.ProviderMetadata;
import org.jclouds.trystack.nova.config.TryStackNovaServiceContextModule;

import com.google.inject.Module;

/**
 * 
 * @author Adrian Cole
 */
public class TryStackNovaContextBuilder extends NovaContextBuilder {

   public TryStackNovaContextBuilder(
         ProviderMetadata<NovaClient, NovaAsyncClient, ComputeServiceContext<NovaClient, NovaAsyncClient>, NovaApiMetadata> providerMetadata) {
      super(providerMetadata);
   }

   public TryStackNovaContextBuilder(NovaApiMetadata apiMetadata) {
      super(apiMetadata);
   }

   @Override
   protected void addContextModule(List<Module> modules) {
      modules.add(new TryStackNovaServiceContextModule());
   }

}