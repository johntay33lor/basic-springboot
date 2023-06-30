First set up the application by using the Spring Initializer and add the necessary
dependencies. Next set up the packages. The controller package is responsible for
handling user requests and managing the endpoints of the application, the model package
defines the behavior of the data, and the repository is used to pull data from the CRUD
which has the methods to manipulate the data. I also created author and book list classes
that has the hardcoded authors and books that will be available to be manipulated. The author
and book controllers use the @GetMapping to define the paths for handling the CRUD operations,
such as adding, editing, and deleting books and authors. In the model package, I added Book and
Author classes to present the necessary properties such as id, title, author name, and the 
actual list of books. Next I created the necessary html files for the operations (list,create,
update,delete). These files would be manipulated with the controller classes allowing the 
correct page to be rendered. To run and test the application you simply open your browser to
localhost:8080 and test to make sure each functionality works properly, and renders the appropriate
page.