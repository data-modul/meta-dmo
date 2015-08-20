# Copyright (C) 2015 Sebastian Wezel <swezel@data-modul.com>
# Released under the MIT license (see COPYING.MIT for the terms)

inherit dmo-launcher-app

DMO_LAUNCHER_EXEC = "/usr/bin/qt5/qmlscene /usr/share/qmlvideotest/qmlvideotest.qml"
DMO_LAUNCHER_NAME = "qmlvideotest"
DMO_LAUNCHER_DESC = "Qml video test application"
DMO_LAUNCHER_ICONPATH = "/usr/share/cinematicexperience-1.0/content/images/qt_logo.png"

DESCRIPTION = "Data Modul qml vidoe test application"
HOMEPAGE = "http://www.data-modul.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SECTION = "graphics"
DEPENDS = "qtbase qtbase-native qtdeclarative"
RDEPENDS_${PN} = "qtbase qtdeclarative qtdeclarative-tools"

SRC_URI = " \
            file://qmlvideotest.qml \
            "
PV = "0.1.1"

S="${WORKDIR}"

do_install() {
    install -d ${D}/usr/share/qmlvideotest
    install -m 755 ${WORKDIR}/qmlvideotest.qml ${D}/usr/share/qmlvideotest
}

PACKAGES = "${PN}" 

FILES_${PN} += "/usr/bin/ /usr/share/qmlvideotest"

