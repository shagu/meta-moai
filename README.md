# meta-moai distribution layer

## Build Dependencies

### Archlinux

    pacman -Sy base-devel chrpath diffstat rpcsvc-proto

### Ubuntu

    tbd

## Prepare Toolchain

    git clone https://git.yoctoproject.org/git/poky moai
    cd moai
    git clone https://git.yoctoproject.org/git/meta-raspberrypi
    git clone https://git.openembedded.org/meta-openembedded
    git clone https://github.com/shagu/meta-moai.git

    TEMPLATECONF=meta-moai/conf/ source oe-init-build-env

## Build Image

    bitbake core-image-minimal
