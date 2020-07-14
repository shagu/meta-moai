SUMMARY = "moai base image"
LICENSE = "MIT"

inherit core-image
inherit extrausers

# read-only rootfs
IMAGE_FEATURES += "read-only-rootfs"

# set root password
EXTRA_USERS_PARAMS = "usermod -P moai root;"

# core dependencies
IMAGE_INSTALL = " \
  packagegroup-core-boot \
  ${CORE_IMAGE_EXTRA_INSTALL}\
  u-boot-fw-utils \
"

# install kernel
IMAGE_INSTALL += " \
  kernel-devicetree \
  kernel-image \
"

# swupdate
IMAGE_INSTALL += " \
  swupdate \
  swupdate-www \
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
}
