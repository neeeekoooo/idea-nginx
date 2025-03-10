/*
 * Copyright 2009 Max Ishchenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ishchenko.idea.nginx.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import net.ishchenko.idea.nginx.NginxBundle;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 14.07.2009
 * Time: 19:10:29
 */
public class NginxConfigurationType implements ConfigurationType {

    NginxConfigurationFactory ncf = new NginxConfigurationFactory(this);

    public String getDisplayName() {
        return NginxBundle.message("cofigurationtype.displayname");
    }

    public String getConfigurationTypeDescription() {
        return NginxBundle.message("configurationtype.description");
    }

    public Icon getIcon() {
        return IconLoader.getIcon("/nginx.png");
    }

    @NotNull
    @Override
    public String getId() {
        return "nginx.configuration.type";
    }

    public String getName() {
        return "nginx.configuration.type";
    }

    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{ncf};
    }

    private static class NginxConfigurationFactory extends ConfigurationFactory {

        @Override
        public String getId() {
            return "nginx.configuration.type";
        }

        public String getName() {
            return "nginx.configuration.type";
        }

        protected NginxConfigurationFactory(@NotNull ConfigurationType type) {
            super(type);
        }

        public RunConfiguration createTemplateConfiguration(Project project) {
            return new NginxRunConfiguration(project, this, NginxBundle.message("cofigurationtype.displayname"));
        }
    }
}
