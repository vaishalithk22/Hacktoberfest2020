import 'package:flutter/material.dart';

class Home extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new HomeState();
  }
}

class HomeState extends State<Home>{

  final TextEditingController _weightController = new TextEditingController();
  double _finalResult = 0.0;
  String _planetName;
  String _planetWeightInfo='Hello There';
  int radioValue = 0;

  void handleRadioValuesChanged(int value){
    setState(() {
      radioValue = value;

      switch(radioValue){
        case 0:
          _finalResult = calculateWeight(_weightController.text, 0.38);
          _planetName = 'Pluto';
          break;

        case 1:
          _finalResult = calculateWeight(_weightController.text, 0.0553);
          _planetName = 'Mercury';
          break;

        case 2:
          _finalResult = calculateWeight(_weightController.text, 0.107);
          _planetName = 'Mars';
          break;
      }

      if(_finalResult > 0.0){
        _planetWeightInfo = 'Your weight on $_planetName is '
            + '$_finalResult pounds';
      }else{
        _planetWeightInfo = 'Your weight must be greater than '
            + '$_finalResult pounds';
      }

    });
  }
  @override
  Widget build(BuildContext context) {

    // TODO: implement build
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Weight on Planet X'),
        centerTitle: true,
        backgroundColor: Colors.black45,
      ),

      backgroundColor: Colors.white,

      body: new Container(
        alignment: Alignment.center,
        child: new ListView(
          padding: const EdgeInsets.all(7.5),
          children: <Widget>[
            new Image.asset(
                'images/planet.png',
                height: 143.2,
                width: 207.5
            ),

            new Container(
              margin: const EdgeInsets.all(7.5),
              alignment: Alignment.center,
              child: new Column(
                children: <Widget>[
                  new Center(
                      child: new TextField(
                        controller: _weightController,
                        keyboardType: TextInputType.number,
                        decoration: new InputDecoration(
                            labelText: 'Enter your weight on Earth',
                            hintText: 'In Pounds (lbs)',
                            icon: new Icon(Icons.person_outline)
                        ),
                      ),
                  ),

                  new Padding(padding: EdgeInsets.all(7.5)),

                  new Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      new Radio<int>(
                        activeColor: Colors.brown,
                        value: 0, groupValue: radioValue,
                        onChanged: handleRadioValuesChanged,
                      ),
                      new Text('Pluto'),

                      new Radio<int>(
                          activeColor: Colors.lightBlueAccent,
                          value: 1, groupValue: radioValue,
                          onChanged: handleRadioValuesChanged
                      ),
                      new Text('Mercury'),


                      new Radio<int>(
                        activeColor: Colors.red,
                        value: 2, groupValue: radioValue,
                        onChanged: handleRadioValuesChanged,
                      ),
                      new Text('Mars'),

                    ]
                  ),
                  new Padding(padding: EdgeInsets.all(20.5)),
                  new Text(
                      (_weightController.text.isEmpty)
                          ? 'Enter a weight value greater than 0'
                          : '$_planetWeightInfo',
                    textAlign: TextAlign.center,
                    style: new TextStyle(
                      fontFamily: 'monospace',
                      fontSize: 23.6,
                      fontWeight: FontWeight.w500,
                      color: Colors.lightBlue
                    )
                  )
                ],
              )
            )
          ],
        ),

      )
    );
  }

  double calculateWeight(String weight, double specificWeight) {
    if(double.parse(weight).toString().isNotEmpty
        && !double.parse(weight).isNaN && double.parse(weight)>0.0 )
      return double.parse(weight) * specificWeight;

    return 0.0;
  }
}

