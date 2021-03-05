# FundamentalProject

**Cloud Native Fundamental Project**

# Watch What App

The purpose of this project is to create an application which follows the requirements listed in the brief and achieves the objective of the project. In order to accomplish this, I have decided to create an app called '*Watch What*' which allows viewers to see my reviews on tv shows that I have watched.
<<<<<<< HEAD
The purpose of this app will help recommend shows to viewers based off my reviews. They will also have the option to create an account which will allow them to add or edit any comments under my reviews.

=======



# Contents:
1. [Introduction](#Introduction)
    1. [Requirements](#Requirements)
    2. [Features in the App](#Features-in-the-App)
2. [Objective](#Objective)
    1. [Meeting the Objective](#Meeting-the-Objective)
3. [Architecture](#Architecture)
4. [Jira Board](#Jira-Board)
5. [Risk Assessment](#Risk-Assessment)
6. Testing
7. Future Improvements

# Introduction
The purpose of the 'Watch What' app will help recommend shows to viewers based off my reviews. They will also have the option to create an account which will allow them to add or edit any comments under my reviews.

## Requirements
The following is the minimum set of requirements for the project:
* A Jira board with user stories, use cases and tasks.
* Documentation describing the architecture used in the project.
* Risk assessment.
* Relational database used to store data from project.
* Functional application.
* Front-end website and integrated API.
* Testing implementation.
* Code integrated into a Version Control System.
* Application deployed to a cloud-based virtual machine.

## Features in the App

The Watch What app will show reviews of tv-shows added to the app. 
When on the home-page, the website will include a list of shows with information including:
* Name of the show
* Genre of the show
* Rating out of 5

After clicking on the name of the show, a new webpage will appear showing extra information of the selected show which includes:
* Short summary
* Criticms
* Image

Since the app will only have my reviews, therefore, I am the only one who can add, edit or delete the reviews. To ensure this, only my log-in details will allow access to the create, edit and delete review buttons.

Viewers of the app can create an account using their email address, a user-name and a password. After logging in, users are able to add, edit and delete comments under each review.

*press a 'thumbs up' or 'thumbs down' button to show whether they agree or disagree with the review. This will have a count next to it to show how many people agree or disagree with the app. Clicking a button will change the colour to present their vote and add to the corresponding vote count. Clicking the same button again will delete their vote from the count and change the colour back to the original.*

The app will have drop-down menus for 'Genre' and 'Rating'. 
The app will automatically list shows in alphabetical order however, this can be changed to be sorted by highest rating or lowest rating. Users can also change the reviews they see based off the genre of the show. These features will allow users to customize the way they can view the list of shows.

# Objective

The objective of this project is to create a CRUD application utilising the tools, methodologies and technologies discussed during the modules taught during training.
This CRUD app will allow the user to create, read, update and delete items on the webapp.

## Meeting the Objective
In order to achieve the objectives, I have created a simple app called *Watch What*. This app will create a list of shows reviewed by myself. 
This app will allow users to do the following:
* Create a new review (user: me) which will include the following information:
    * Name of show
    * Genre
    * Rating
    * Summary of show
    * Criticism
    * An image
* View the information submitted in the review (user: anyone)
* Update the information in the reviews (user: me), this can include:
    * Editing information already uploaded
    * Making any corrections (i.e. Grammar, spelling etc.)
    * Changing the image
* Delete any reviews that have been uploaded (user: me)
* Create a new vote through the thumbs up/down button (user: anyone) which will update the vote count.
* View the number of votes for each thumb up/down button.
* Update a vote by clicking the same button and then selecting the other thumbs up/down option to change their vote (user: anyone) which will remove their vote from the count. However, the user can only change their vote that they previously selected.
* Delete a vote (user: anyone) by clicking the same button and not re-selecting another vote option. This will remove a vote count.
* Create a new account (user: anyone) using the following information:
    * email address
    * user-name
    * password
* View comments added by other users (user: anyone).
* Update their comment under a review (user who created comment) by making any changes
* Delete comment or account (user: anyone).

<<<<<<< HEAD



=======
# Risk Assessment
Link to the full risk assessment can be found here:
[Risk Assessment](https://docs.google.com/spreadsheets/d/15b4NV8_hYK5qgIZLMVYyuaRH7KrbpBTeHN9K1fcmpyo/edit?usp=sharing)

The screenshot of the risk assessment shows the potential risks that could occur from the app. It is important to assess these risks and plan ahead by implementing features that could prevent it.







