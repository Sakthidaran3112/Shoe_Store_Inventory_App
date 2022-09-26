# The Shoe Store
This App was developed as a part of the Udacity Android Kotlin Developer Nanodegree Course for the Project "Shoe Store Inventory app". In this project I applied my skills and knowledge in building layouts and navigation between the fragments. The app consist of five screens:

Login
Onboarding
Instruccions
Shoe list
Shoe detail

## Recieved some appreciation from the Reviewer

![1](https://user-images.githubusercontent.com/113074664/192350370-a404bc98-f43e-450f-9603-d94df3336801.png)

![2](https://user-images.githubusercontent.com/113074664/192350433-efb24636-646d-4983-82b4-21444427c3af.png)

![3](https://user-images.githubusercontent.com/113074664/192350476-1c98263b-f264-4a03-8f02-f32fadd29f43.png)

## Application UI

![Login](https://user-images.githubusercontent.com/113074664/192354113-1121694f-1e46-4155-8852-1d6455ec995d.png)

![Welcome_Screen](https://user-images.githubusercontent.com/113074664/192354149-e01c4a89-2f3d-4fc4-8b98-360d685dc698.png) 

![Instruction_Screen](https://user-images.githubusercontent.com/113074664/192354198-cd82c5a3-8779-4f62-a1a2-cc6d7235c70a.png) 

![Shoe_List_Screen](https://user-images.githubusercontent.com/113074664/192354227-ce75e21e-06c1-4427-b39c-b2ae67499cb0.png) 

![Shoe_Detail_Screen](https://user-images.githubusercontent.com/113074664/192354695-ace25b2b-938c-404e-b009-9d488c0bc4b0.png)

## Navigation

![image](https://user-images.githubusercontent.com/113074664/192354950-bf601c68-5dc6-4186-9021-4816f9a2524c.png)





## Guidelines of the Project 

This project will consist of five screens. You don't have to create a shoe store, you can use any other item as long as you create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

##Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Create a new navigation xml file

5. Create a new Login destination.

   * Include email and password labels 

   - Include email and password fields
   - Create buttons for creating a new login and logging in with an existing account
   - Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the shoe list screen

8. Create a class that extends ViewModel

   *  Use a LiveData field that returns the list of shoes

9. Create a new Shoe List destination that includes:

   * A new layout
   * A ScrollView
   * A LinearLayout for Shoe Items
   * A FloatingActionButton with an action to navigate to the shoe detail screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Shoe Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Shoe Name
      * Company
      * Shoe Size
      * Description
    * A Cancel button with an action to navigate back to the shoe list screen
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

12. Make sure you can’t go back to onboarding screens

13. In the Shoe List screen:

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Use DataBindingUtil to inflate the shoe_list layout
    * Add a new layout item into the scrollview for each shoe.
