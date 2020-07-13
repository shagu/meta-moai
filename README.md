# meta-moai distribution layer

## Build Dependencies

### Archlinux

    pacman -Sy base-devel chrpath diffstat rpcsvc-proto

### Ubuntu

    apt install gawk wget git-core diffstat unzip texinfo gcc-multilib \
      build-essential chrpath socat libsdl1.2-dev xterm

## Prepare Toolchain

    git clone https://git.yoctoproject.org/git/poky moai
    cd moai
    git clone https://git.yoctoproject.org/git/meta-raspberrypi
    git clone https://git.openembedded.org/meta-openembedded
    git clone https://git.yoctoproject.org/git/meta-java
    git clone https://github.com/sbabic/meta-swupdate
    git clone https://github.com/shagu/meta-moai.git

    TEMPLATECONF=meta-moai/conf/ source oe-init-build-env

## Build Image

    bitbake moai-image
