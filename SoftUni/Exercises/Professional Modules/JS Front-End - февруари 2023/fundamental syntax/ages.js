function determaneAgeStatus(age) {
    let status = "";
    if(age < 0) status = 'out of bounds';
    else if(age <= 2) status = 'baby';
    else if(age <= 13) status = 'child';
    else if(age <= 19) status = 'teenager';
    else if(age <= 65) status = 'adult';
    else status = 'elder';
    
    console.log(status);
}