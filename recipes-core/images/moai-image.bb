SUMMARY = "moai base image"
LICENSE = "MIT"

inherit core-image

# core dependencies
IMAGE_INSTALL = " \
  packagegroup-core-boot \
  ${CORE_IMAGE_EXTRA_INSTALL}\
"

# base moai userland
IMAGE_INSTALL += " \
  packagegroup-core-ssh-dropbear \
  bash htop vim git screen \
"

# eq3 homematic
IMAGE_INSTALL += " \
  openjre-8 \
"

ROOTFS_POSTPROCESS_COMMAND += "moai_image_config;"

moai_image_config() {
  # disable ssh blank pw login
  sed -i 's_-B__' ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear

  # set hostname
  echo "${IMAGE_HOSTNAME}" > ${IMAGE_ROOTFS}${sysconfdir}/hostname

  # set root password
  sed -i "s_root::_root:${IMAGE_ROOTPW}:_" ${IMAGE_ROOTFS}${sysconfdir}/shadow
}
