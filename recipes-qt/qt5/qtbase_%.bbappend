EXTRA_OECONF_append += "-qpa ${@base_contains('DISTRO_FEATURES', 'x11', 'xcb', 'eglfs', d)}"

