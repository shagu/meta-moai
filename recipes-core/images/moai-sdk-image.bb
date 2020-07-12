SUMMARY = "moai sdk image"
LICENSE = "MIT"

require moai-image.bb

IMAGE_FEATURES += "dbg-pkgs dev-pkgs tools-sdk tools-debug"
IMAGE_FEATURES += "package-management"
