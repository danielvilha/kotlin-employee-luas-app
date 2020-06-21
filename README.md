# RIM Employee LUAS App
This is an app that shows *Stillorgan's Incoming* and *Marlborough Outgoing* trams.

* This app only works if you run it on a device, I haven't had time yet to look at why it isn't running on an emulator.

### Overview
Many people travel from the city center to the office using LUAS. To avoid waiting too long at the stops, people can use this app where you can see the forecast of the trams. This is a single screen app, using MVVM and architecture pattern, showing the direction of the trams, and there is a button for updating the information.

### Libraries used in the Project
- [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- [RxJava](https://github.com/ReactiveX/RxAndroid)
- [Retrofit](https://square.github.io/retrofit/)
- [Dagger](https://github.com/google/dagger)
- [TikXML parser](https://github.com/Tickaroo/tikxml)
- [Firebase](https://firebase.google.com)

### Screenshots
Marlborough Outbound | Stllorgan Inbound
--- | ---
![Marlborough](/image/Screenshot_20200621-030920.jpg) | ![Stillorgan](/image/Screenshot_20200621-150908.jpg)

## Licence
Copyright 2020 Daniel Freitas Vilha

```
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
of the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
