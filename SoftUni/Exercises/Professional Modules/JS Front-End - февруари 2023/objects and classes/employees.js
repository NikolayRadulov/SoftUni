function getEmployees(employees) {
    class Employee {
        constructor(name) {
            this.name = name;
            this.personalNumber = name.length;
        }

        print() {
            console.log(`Name: ${this.name} -- Personal Number: ${this.personalNumber}`);
        }
    }

    let array = [];
    for(let i = 0; i < employees.length; i++) {
        array.push(new Employee(employees[i]));
    }
    array.forEach(employee => employee.print());
}
