# Download Manager Application
This application is totally based on Jetpack Compose:

# Finished Part:

In this application, We have mainly 2 tabs are available:

1. Home: 
In the home tab, there is one text field, one download button and one image view.
When you add the URL into text filed, the image is directly displays on the image view below.
Only after click on download button, You can see the image is downloaded.
You can rotate the device and see the data is available as it is. 

2. Image URL: 
In this tab, while you are coming for the first time, you don't see any image urls.
You can see the normal text when there is no data available in the room database.
While from the home screen you download the image, you can see the same URL in the database 
and also in the ImageUrl screen as well.  

[Note]: Have added the test for room database as well.

Tech Stack Used:
- Jetpack Compose for UI 
- Room Database for storing the data
- Navigation
- Material 3 
- Hilt
- LiveData
---------------------------------------------------------------------------------------------

# Additional features I would like to add:

1. Add UI tests in jetpack compose.[Still Learning]
2. List of ImageUrls via Pagination.
3. Improve the UI with adding more animations.

