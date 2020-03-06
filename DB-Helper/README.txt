TODO: Integrate with TakeMeAway app

To test the sqlite database helper (currently only SQL insert):
1) Start the app on android emulator
2) Update the title and content via the launched app and click on the button
NOTE: sql update func not integrated yet, not enough time to integrate it for testing. Currently, this app can only insert new records.

3) After submitting a few records, while the app is still running, go back Android Studio and Browse to View > Tool Windows > Device File Explorer (DFE)

4) In the DFE, browse to data > data > [app_name] > databases, where [app_name] is au.edu.murdoch.ict.376.dbhelpertest in this case.

5) right click on takemeaway.db and select Save As and save the file to a location on your local system.

6) Launch the "DB Browser for SQLite" program and browse the the folder where you saved the .db file. If you do not have the program, please install from https://sqlitebrowser.org/dl/, they have a version for macOS as well.

7) Drag and drop the .db file into the "DB Browser for SQLite" program. The data you inserted can be found under the Browse Data tab and tmaTravelPost table under the dropdown.