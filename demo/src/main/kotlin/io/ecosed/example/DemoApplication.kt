/**
 * Copyright EcosedKit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.ecosed.example

import android.app.Application
import io.ecosed.embedding.EcosedApplication
import io.ecosed.embedding.EcosedHost
import io.ecosed.embedding.EcosedPlugin
import io.ecosed.embedding.IEcosedApplication

class DemoApplication : Application(), IEcosedApplication by EcosedApplication<DemoApplication>() {

    private val mHost: EcosedHost = object : EcosedHost {
        override fun isDebug(): Boolean {
            return BuildConfig.DEBUG
        }

        override fun getPluginList(): ArrayList<EcosedPlugin> {
            return arrayListOf(DemoPlugin())
        }
    }

    override fun onCreate() {
        super.onCreate()
        attachEcosed(
            application = this@DemoApplication,
            host = mHost
        )
    }
}