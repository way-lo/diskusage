DiskUsage
=========

For a better maintained version of this project have a look at:
https://github.com/WhiredPlanck/diskusage

DiskUsage app for Android

DiskUsage provides a way to find files and directories on storage card which consumes a lot of space.<br>
It displays diagram on which directories are displayed proportional to their size, also a few levels of subdirectories are displayed. Users are allowed to zoom in to look at specific directory content.<br>
Purpose of the program is to provide a way to find and cleanup spacehogs on storage card. It is not general purpose file manager.<br>

Screenshot for an ancient version:<br>
<img src="extra/screenshot.png">

YouTube video:
https://www.youtube.com/watch?v=TIiCQfWdtVg

v5.1 updated 9/7/26
App has been updated to properly request the "All Files Access" permission so that your MEDIA partition is now accessible and accounted for.
1. targetSdkVersion 30 → 34 (Play policy lint)
2. SelectActivity — added android:exported="true" (required at targetSdk 31+)
3. PermissionRequestActivity.java — decoupled usage-access from storage-access checks, added checkStorageThenForward(), and now fixed the actual intent action (ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION instead of the list-only variant)
4. progress.xml — fixed the percent/path overlap from the ConstraintLayout migration
5. MountPoint.java — dynamic package name instead of a 2010-era hardcoded string
6. versionCode/versionName bumped so this build is distinguishable from stock
7. .github/workflows/build.yml — full working CI pipeline (NDK, targetSdk lint tolerance, debug/release split)
