/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.core.types;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.smarthome.core.internal.types.CommandDescriptionImpl;

/**
 * Used to build instances of {@link CommandDescription}.
 *
 * @author Henning Treu - Initial contribution
 */
public class CommandDescriptionBuilder {

    private final List<CommandOption> commandOptions = new ArrayList<>();

    private CommandDescriptionBuilder() {
        // prevent public instantiation
    }

    /**
     * Create and return a fresh builder instance.
     *
     * @return a fresh {@link CommandDescriptionBuilder} instance.
     */
    public static CommandDescriptionBuilder create() {
        return new CommandDescriptionBuilder();
    }

    /**
     * Build a {@link CommandDescription} from the values of this builder.
     *
     * @return a {@link CommandDescription} from the values of this builder.
     */
    public CommandDescription build() {
        CommandDescriptionImpl commandDescription = new CommandDescriptionImpl();
        commandOptions.forEach(co -> commandDescription.addCommandOption(co));
        return commandDescription;
    }

    /**
     * Add a {@link CommandOption} for the resulting {@link CommandDescription}.
     *
     * @param commandOption a {@link CommandOption} for the resulting {@link CommandDescription}.
     * @return this builder.
     */
    public CommandDescriptionBuilder withCommandOption(CommandOption commandOption) {
        this.commandOptions.add(commandOption);
        return this;
    }

    /**
     * Set the {@link CommandOption}s for the resulting {@link CommandDescription}.
     *
     * @param commandOptions the {@link CommandOption}s for the resulting {@link CommandDescription}.
     * @return this builder.
     */
    public CommandDescriptionBuilder withCommandOptions(List<CommandOption> commandOptions) {
        commandOptions.forEach(co -> this.commandOptions.add(co));
        return this;
    }
}
