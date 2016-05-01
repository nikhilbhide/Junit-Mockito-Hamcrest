# Junit-Mockito-Hamcrest

Testing is important part of software development process. It ensures that whatever developed follows the requirements and implemented logic is as per the business needs. Unit test is important part of testing life cycle in which developer verifies the logic of the program written. Unit is the smallest possible unit of behavior that can be tested (there are many point of views about unit tests). Unit testing should focus on business rules/ functionality logic and it should be executed in isolation. Integration test should involve testing of different components and should cover an entire functionality (in agile model, its user story). These tests should be automated.

I prefer to use TDD approach and for unit testing and integration testing, I prefer to use following technologies:
1. Mockito, Junit and Hamcrest
2. MockMvc (to test MVC - Spring MVC)
3. Karma and Jasmine for Angular JS

##### I strongly advise Test Driven Development.
-----------------------------------------------------------------------------------------------------------------------
This short tutorial demonstrates how to use Mockito, Junit and HamCrest for unit testing of Order Management System.
Order Management System is a small ecommerce application.

-----------------------------------------------------------------------------------------------------------------------
###  How to build?

The project is based on maven and can be built using maven commands.
Run mvn install or run mvn package
It requires Java 1.8

-----------------------------------------------------------------------------------------------------------------------
### Junit
Popular testing framework for Java. It has been instrumental in TDD and provides a basic testing framework for Java application. Since Junit 4.x, it's possible to use different annotations to write test cases.
You can integrate junit with the build tool to carry out continuous integration tests.
Eg: One can configure Jenkins to run unit tests and integration tests (using ant or maven).
Unit tests are executed as a part of build.
Integration tests are executed after deployment.

Purpose is to improve the quality and reduce the defects. Unit tests also improvises the class design.

-----------------------------------------------------------------------------------------------------------------------
### Mockito
Very popular framework for creating mock objects in Java.
Its best among the available ones.
Unit tests should be executed in isolation and side effects from other classes should be eliminated.
For that some kind of mocking is required. There are many alternatives such as test doubles, stubs or mocks.
Among them, mocks are popular. A mock object can be created from interface or class.

@mock or mock() - create mock object
when(....).thenReturn(....) call chain - specify a condition and a return value for this condition
It actually calls the method.
@Spy or the spy() method - wrap a real object. Every call, unless specified otherwise, is delegated to the object.
It can be used for partial mocking.
verify() - Mockito keeps track of called methods and parameters passed to it. Verify() can be used for behavior testing.
verify() can be used to check whether method is called with certain parameters. It can be used to check whether method was called with right parameters.
@injectMocks - For depedency injection via Mockito
doReturn(...).when(...).methodCall - It does not actually call the method.

-----------------------------------------------------------------------------------------------------------------------
### HamCrest
Hamcrest is a testing framework which allows checking condition with predefined matchers or custom matchers.
It makes test cases readable. It is a third generation matcher framework.

allOf - matches if all matchers match (short circuits)
anyOf - matches if any matchers match (short circuits)
not - matches if the wrapped matcher doesn't match and vice versa
equalTo - test object equality using the equals method
is - decorator for equalTo to improve readability
hasToString - test Object.toString
instanceOf, isCompatibleType - test type
notNullValue, nullValue - test for null
sameInstance - test object identity
hasEntry, hasKey, hasValue - test a map contains an entry, key or value
hasItem, hasItems - test a collection contains elements
hasItemInArray - test an array contains an element
closeTo - test floating point values are close to a given value
greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - test ordering
equalToIgnoringCase - test string equality ignoring case
equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace
containsString, endsWith, startsWith - test string matching











