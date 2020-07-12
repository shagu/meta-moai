SUMMARY = "moai base image"
LICENSE = "MIT"

inherit core-image
inherit extrausers

# set root password
EXTRA_USERS_PARAMS = "usermod -P moai root;"

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
}
