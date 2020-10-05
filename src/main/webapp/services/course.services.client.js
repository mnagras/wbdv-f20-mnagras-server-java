function AdminCourseServiceClient() {
    this.createCourse = createCourse;
    this.findAllCourses = findAllCourses;
    this.findCourseById = findCourseById;
    this.deleteCourse = deleteCourse;
    this.updateCourse = updateCourse;
    this.url = 'https://cs4550-hw1-mnagras.herokuapp.com/courses';
    var self = this;
    //var localURL = "http://localhost:8080/courses";
    //this.url =  "http://localhost:8080/courses";

    function createCourse(course) {
        return fetch(this.url, {
            method: "POST",
            body: JSON.stringify(course),
            headers: {
                "content-type": "application/json"
            }
        }).then(function(response){
            return response.json()
        })
    }

    function findAllCourses() {
        return fetch(this.url)
                .then(function(response){
                    return response.json()
            })
    }

    function deleteCourse(courseId) {
        return fetch(this.url + "/" + courseId, {
            method: "DELETE"})
            .then(function(response){
                return response.json()
            })
    }

    function findCourseById(courseId) {  }

    function updateCourse(courseId, course) {
        course.courseId = courseId;
        return fetch(this.url, {
            method: "PUT",
            body: JSON.stringify(course),
            headers: {
                "content-type": "application/json"
            }
            }).then(function(response){
                return response.json()
            })
    }
}
