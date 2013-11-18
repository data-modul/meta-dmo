# Copyright (C) 2011-2012 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

PV = "3.9rc7+git${SRCREV}"
PR = "${INC_PR}.8"

require linux-dmo.inc

SRC_URI = "git://git@emb.data-modul.com/development/linux;protocol=ssh \
           file://defconfig \
           file://fsl_otp-compile-problem.patch \
"
S = "${WORKDIR}/git"

KERNEL_PRIORITY = "10000"

COMPATIBLE_MACHINE = "(mx6)"

SRCREV = "dc3e84446654284433d72ef7a71ae058edb1a59a"

