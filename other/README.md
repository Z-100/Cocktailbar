# Cocktailbar Documentation

Table of contents
* [What is "Cocktail Bar"?](#functionality)
* [The process of the project](#process)
  * [The analysis](#analysis)
  * [The design](#design)
  * [The implementation](#implementation)
  * [Testing](#testing)

## Process
In this section we'll be looking at the entirety of the process of me creating this so-called project "Cocktail Bar"!

### Analysis
#### Functionality
First off: Yes. The project's full potential was and could not be used in a span of just 5 weeks. 
<br/><br/>
Let me explain: I'm more of a backend developer. That means, I prefer to work on the "_backendy_" side of things. This concludes to the result of me focusing on the backend. In this case, this meant, that the API of the project has about 4x the amount of features and requests it could handle than I could've ever implemented in the frontend.
<br/><br/>
Another reason the backend is that much better(?) than the frontend, is that I've only just learned React. With this project I, for the first time ever, installed any npm stuff, but for my first time working with any JavaScript stuff, I'm pretty happy with how it turned out!
<br/><br/>
**The functionality sheet can be viewed here: _[Functionality_Sheet.md](https://github.com/Z-100/Cocktailbar/blob/master/other/analysis/README.md)_**

### Design
The entirety of the desing process can be viewed at: _[Design_Process.md](https://github.com/Z-100/Cocktailbar/blob/master/other/design/README.md)_
### Implementation
Compared to the other phases of this project, the implementation took an extreme amount of my freetime.
<br/><br/>
I started off by creating the structre for both the front- and backend. After that I pretty much ignored the frontend, until the backend was finished. Yeah. That's it.
<br/>
But I'll be expanding the whole implementation-process-explanation a bit, for the sake of a better grade:<br/>

#### **Backend**
Everything started with me creating the base structure. After that, I started implementing the _[RESTful API-structre](https://github.com/Z-100/Cocktailbar/tree/master/API/src/main/java/com/ctb/api/components)_, with the knowledge of previous Spring Boot projects and the diagrams I've created in the _[analyis](#analysis)_ and _[design](#design)_ process. 
<br/><br/>
After all the entities, DTOs and CRUD-repositorys were finished, I continued by implementing the DTO<->DAO mappers: For this I used a library so-called "MapStruct". This library prevents boilerplate code, by just writing the code of interfaces and/or abstract classes. After that, MapStruct generates the boilerplate code, so no one has to write it.
<br/><br/>
Then, I started the construction of the Controllers. Controllers are used to communicate with the outside world and the backend. But as I wanted to even have a multi-layer n-tier architecture in the backend, resulting in a 6-tier-architecture* overall, I also had to write services for validation, generation and other things and also database-access-and-modify classes.

#### **Frontend**
The construciton of the frontend started at the same time as I've started implementing the backend. But I only continued it after weeks of backend work:<br/>
The start was made, by just watching tutorials on youtube or reading _[documentations](https://context.reverso.net/translation/english-spanish/That+was+obviously+a+lie.+I%27m+not+reading+documentations)_. That also was around the time, I firstly implemented TailwindCSS.<br/>
Yes. Firstly. I had to repeat that process around four more times, as something wasn't working all the time. I somehow also uploaded 180'000 lines of CSS to GtiHub.<br/><br/>
This entire process can't be sectioned as I was working on everything all at the same time.
<br/>
The static pages were the easiest to create, as I only had to show text on them.
<br/>
The dynamic pages however were pretty difficult to finish sometimes. As I have e.g. implemented the async requests the wrong way and the login was working, _but_... I had to press a button twice.


\*Frontend: Presentation-layer, API-access-layer, backend: communication-layer, service-layer, database-access-layer, database: database-layer
<br/>
_I don't care what you're thinking. It's true, I counted them by myself_

### Testing
The testing was fairly easy to do and very helpful, as most of the components and pages already were working.
<br/>
As said: "most of the components and pages"; With the testing I determined all the components that did not work yet or were poorly designed.
<br/>
With this knowledge I settled on a journy of bug-fixing: Most of the bugs were smaller bugs, which caused bigger problems. The biggest problem was, that I, at the first glance, had no idea on how I should be solving those bugs, as these bugs weren't any typical programming bugs I've already encountered or had the knowledge on how to start problemsolving. Those bugs were React-specific bugs, which I, at the time, could not handle, nor solve. 
<br/>
<br/>
But then the unthinkable happened: I somehow solved all of them, by the usage of StackOverflow.
<br/>
After all bugs were solved I created a very nicley formatted test-case-document, where everything was OK.
<br/>
#### **This document can be found here: _[Test_cases.md](https://github.com/Z-100/Cocktailbar/blob/master/other/test/README.md)_**
