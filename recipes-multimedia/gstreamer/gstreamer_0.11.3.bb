SUMMARY = "GStreamer multimedia framework"
DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://gst/gst.h;beginline=1;endline=21;md5=8e5fe5e87d33a04479fde862e238eaa4"
DEPENDS = "glib-2.0 libxml2 bison-native flex-native"

PR = "r1"

SRC_URI = "http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-${PV}.tar.bz2 \
           file://0001-fix-compiling-with-disable-trace.patch"

SRC_URI[md5sum] = "dc8b876b3f61711adfe742bea8ddebfd"
SRC_URI[sha256sum] = "86461df7375ef7b07e0383e3e8bc79cc71e0e14a7d35e2c87ddc5d04ce352ef3"

require gstreamer.inc
inherit autotools pkgconfig gettext

GSTREAMER_DEBUG ?= "--disable-debug"
EXTRA_OECONF = "${GSTREAMER_BASE_CONFIG} \
                ${GSTREAMER_DEBUG} \
                --disable-trace --disable-alloc-trace --enable-registry \
                --enable-plugin --disable-tests --disable-failing-tests \
                --disable-poisoning --disable-introspection --disable-docbook \
                --disable-check --enable-Bsymbolic"

# apply gstreamer hack after Makefile.in.in in source is replaced by our version from
# ${STAGING_DATADIR_NATIVE}/gettext/po/Makefile.in.in, but before configure is executed
# http://lists.linuxtogo.org/pipermail/openembedded-core/2012-November/032233.html
oe_runconf_prepend() {
        sed -i -e "1a\\" -e 'GETTEXT_PACKAGE = @GETTEXT_PACKAGE@' ${S}/po/Makefile.in.in
}

#do_compile_prepend () {
#	mv ${WORKDIR}/gstregistrybinary.[ch] ${S}/gst/
#}

RRECOMMENDS_${PN}_qemux86    += "kernel-module-snd-ens1370 kernel-module-snd-rawmidi"
RRECOMMENDS_${PN}_qemux86-64 += "kernel-module-snd-ens1370 kernel-module-snd-rawmidi"

FILES_${PN} += " ${libdir}/gstreamer-0.11/*.so"
FILES_${PN}-dev += " ${libdir}/gstreamer-0.11/*.la ${libdir}/gstreamer-0.11/*.a"
FILES_${PN}-dbg += " ${libdir}/gstreamer-0.11/.debug/ ${libexecdir}/gstreamer-0.11/.debug/"
