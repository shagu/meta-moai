DESCRIPTION = "Generate SWUpdate compatible moai image"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit swupdate

SRC_URI = "\
  file://sw-description \
  file://postinstall.sh \
"

# images to build before building swupdate image
IMAGE_DEPENDS = "moai-image"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = "moai-image"
SWUPDATE_IMAGES_FSTYPES[moai-image] = ".ext4.gz"

# replace machine name in sw-description
do_machine () {
  sed -i "s/MACHINE/${MACHINE}/" ${WORKDIR}/sw-description
}

addtask machine before do_swuimage
do_swuimage[postfuncs] += "do_machine"
