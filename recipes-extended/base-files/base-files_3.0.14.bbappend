
do_install_append () {
    install -d ${D}/media/card

    echo "tmpfs          /media tmpfs defaults 0 2" >> ${D}/${sysconfdir}/fstab
    echo "/dev/mmcblk0p3 /home  auto  defaults 0 2" >> ${D}/${sysconfdir}/fstab
}
