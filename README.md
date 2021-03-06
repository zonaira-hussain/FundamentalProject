# FundamentalProject

**Cloud Native Fundamental Project**

# Watch What App

The purpose of this project is to create an application which follows the requirements listed in the brief and achieves the objective of the project. In order to accomplish this, I have decided to create an app called '*Watch What*' which allows viewers to see my reviews on tv shows that I have watched.
The purpose of this app will help recommend shows to viewers based off my reviews. They will also have the option to create an account which will allow them to add or edit any comments under my reviews.




# Contents:
1. [Introduction](#Introduction)
    1. [Requirements](#Requirements)
    2. [Features in the App](#Features-in-the-App)
2. [Objective](#Objective)
    1. [Meeting the Objective](#Meeting-the-Objective)
3. [Architecture](#Architecture)
4. [Jira Board](#Jira-Board)
5. [Risk Assessment](#Risk-Assessment)
6. [Testing](#Testing)
7. Future Improvements

# Introduction
The purpose of the 'Watch What' app will help recommend shows to viewers based off my reviews.

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

The home page will contain buttons which will lead users to a page where they can create, read, update and delete reviews.

The app will have search-by options for 'review ID', 'Genre' and 'Rating'. 


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

* View the information submitted in the review (user: anyone)
* Update the information in the reviews (user: me), this can include:
    * Editing information already uploaded
    * Making any corrections (i.e. Grammar, spelling etc.)
* Delete any reviews that have been uploaded (user: me)

## Architecture 

To create the front-end of my application, I used HTML with CSS to create and design the web-page. I used JavaScript to make my app interactive for users and allow CRUD operations to be created through JS Http reuests.

## Jira Board

The following is a screenshot of my Jira board:
![image](https://user-images.githubusercontent.com/78487653/110219805-4238cb80-7eb9-11eb-92ae-901943b3360e.png)

Jira is one of the leading technologies in agile project management. 
I used a Jira board during the planning part of the application. This helped me plan out the tasks I had to do to complete my project. I was able to create user stories with smaller tasks attached to each. By splitting the tasks up into smaller tasks, I was able to estimate the length of time each user story and sprint will take to complete.

To each user story, I added a label which represents MoSCoW prioritisations.
M - Must have,
S - Should have,
C - Could have,
W - Would like to have.


# Risk Assessment
Link to the full risk assessment can be found here:
[Risk Assessment](https://docs.google.com/spreadsheets/d/15b4NV8_hYK5qgIZLMVYyuaRH7KrbpBTeHN9K1fcmpyo/edit?usp=sharing)

The screenshot of the risk assessment shows the potential risks that could occur from the app. It is important to assess these risks and plan ahead by implementing features that could prevent it.

![image](https://user-images.githubusercontent.com/78487653/110219272-24b63280-7eb6-11eb-87b6-50c39ae5c2a6.png)


## Testing 
![image](https://user-images.githubusercontent.com/78487653/110221835-50411900-7ec6-11eb-8fca-25f9978ce4e7.png)

For testing I used Mockito. This makes Spring create a mocked version of an object so the real method doesn't have to be called.
Mockito follows the given-when-then system for testing.  

![image](https://user-images.githubusercontent.com/78487653/110222508-a021df00-7eca-11eb-86ed-1c2f8d325166.png)

A high test coverage ensures majority of the code has been used. This follows good design principles as it ensures only code that is being used is contained in the file.




