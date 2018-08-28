# CS430_HomerW2Assignment
Week 2 Assignment CS430 Class

import { TouchID } from '@ionic-native/touch-id';

constructor(private touchId: TouchID) { }

...

this.touchId.isAvailable()
  .then(
    res => console.log('TouchID is available!'),
    err => console.error('TouchID is not available', err)
  );

this.touchId.verifyFingerprint('Scan your fingerprint please')
  .then(
    res => console.log('Ok', res),
    err => console.error('Error', err)
  );
