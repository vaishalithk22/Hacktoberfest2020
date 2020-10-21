let weight = 60 //in kilogram
let height = 170 //in meter

console.log(calculateBMI(weight, height))

function calculateBMI(weight, height){
    weight = Number(weight)
    height = Number(height)

    height = height / 100

    let bmi = weight / (height * height)

    if(bmi){
        return bmi
    }
    else{
        return 'Invalid input!'
    }
}