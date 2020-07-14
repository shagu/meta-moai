#!/bin/sh
if [ "$(fw_printenv rpipart | cut -d = -f 2)" = "3" ]; then
  fw_setenv rpipart 2
else
  fw_setenv rpipart 3
fi

reboot
