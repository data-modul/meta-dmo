# Copyright (C) 2015 Sebastian Wezel <swezel@data-modul.com>

DESCRIPTION = "Initramfs with systemd"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

RDEPENDS_${PN} = "bash udev"

SRC_URI = "git://git@emb.data-modul.com/development/initscripts;branch=master;protocol=ssh"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
PV = "1.0+git${SRCPV}"

do_install(){
    install -m 0755 ${S}/init-overlay.sh ${D}/init
    echo "INITVERSION=${PV}" > ${D}/scriptversion
}

FILES_${PN} += "/init /scriptversion"

