package org.jvnet.hudson.plugins.platformlabeler;

import java.io.Serializable;

/** Stores the platform details of a node. */
public class PlatformDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final String architecture;
    private final String version;
    private final String windowsFeatureUpdate;
    private final String architectureNameVersion;
    private final String architectureName;
    private final String nameVersion;

    /**
     * Platform details constructor (deprecated).
     *
     * @param name name of operating system, as in windows, debian, ubuntu, etc.
     * @param architecture hardware architecture, as in amd64, aarch64, etc.
     * @param version version of operating system, as in 9.1, 14.04, etc.
     */
    @Deprecated
    public PlatformDetails(String name, String architecture, String version) {
        this(name, architecture, version, null);
    }

    /**
     * Platform details constructor.
     *
     * @param name name of operating system, as in windows, debian, ubuntu, etc.
     * @param architecture hardware architecture, as in amd64, aarch64, etc.
     * @param version version of operating system, as in 9.1, 14.04, etc.
     * @param windowsFeatureUpdate windows feature update version string, as in 1809, 1903, 2009,
     *     2103, etc.
     */
    public PlatformDetails(String name, String architecture, String version, String windowsFeatureUpdate) {
        this.name = name;
        this.architecture = architecture;
        this.version = version;
        architectureNameVersion = architecture + "-" + name + "-" + version;
        architectureName = architecture + "-" + name;
        nameVersion = name + "-" + version;
        String featureUpdate = windowsFeatureUpdate;
        if (featureUpdate != null && featureUpdate.isEmpty()) {
            featureUpdate = null;
        }
        this.windowsFeatureUpdate = featureUpdate;
    }

    public String getName() {
        return name;
    }

    public String getArchitecture() {
        return architecture;
    }

    public String getVersion() {
        return version;
    }

    public String getArchitectureNameVersion() {
        return architectureNameVersion;
    }

    public String getArchitectureName() {
        return architectureName;
    }

    public String getNameVersion() {
        return nameVersion;
    }

    public String getWindowsFeatureUpdate() {
        return windowsFeatureUpdate;
    }
}
