# enable busybox http server
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://systemd-no-pager.sh"

do_install_append () {
  install -d -m 0755 -d ${D}/${sysconfdir}/profile.d
  install -m 0755 ${WORKDIR}/systemd-no-pager.sh ${D}/${sysconfdir}/profile.d/
}

FILES_${PN} += "${sysconfdir}/profile.d"
