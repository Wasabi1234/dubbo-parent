/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.config;

import org.apache.dubbo.bootstrap.DubboBootstrap;

/**
 * Please avoid using this class for any new application,
 * use {@link org.apache.dubbo.config.service.ReferenceConfig} instead.
 */
@Deprecated
public class ReferenceConfig<T> extends org.apache.dubbo.config.service.ReferenceConfig<T> {
    DubboBootstrap bootstrap = DubboBootstrap.getInstance();

    @Deprecated
    public synchronized T get() {
        // bootstrap guarantees only started once.
        bootstrap.start();
        return (T) bootstrap.refer(this);
    }

    @Deprecated
    public void destroy() {
        bootstrap.unRefer(this);
    }

}
