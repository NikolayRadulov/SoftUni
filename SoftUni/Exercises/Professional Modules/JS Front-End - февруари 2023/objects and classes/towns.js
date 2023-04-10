function getTowns(towns) {
    class Town {
        constructor(town, latitude, longitude) {
            this.town = town;
            this.latitude = parseFloat(latitude).toFixed(2);
            this.longitude = parseFloat(longitude).toFixed(2);
        }
        print() {
            return `{ town: '${this.town}', latitude: '${this.latitude}', longitude: '${this.longitude}' }`
        }
    }
    let townArray = [];
    towns.forEach(element => {
        let tokens = element.split(' \| ');
        townArray.push(new Town(tokens[0], tokens[1], tokens[2]));
    });
    townArray.forEach(town => console.log(town.print()));
}
