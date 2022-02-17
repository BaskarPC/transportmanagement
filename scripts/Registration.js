function formatCurrency(num)
{
alert("Start FormatCurrency() check");
    var num1;
    if (numMoney(num)==true && num.value.length > 0)
    {
        num1 = removeCommas(num.value);
        if (num1.indexOf('.')==-1 && num1.length>12)
        {
            alert("Currency beyond Maximum limit ! Please re-enter");
            num.focus();
            num.select();
            return (0);
        }
      //  if (num1.indexOf('.')> -1 && num1.length>11)
        //{
          //  alert("Currency beyond Maximum limit ! Please re-enter");
            //num.focus();
            //num.select();
            //return (0);
        //}
        
        if(parseInt(num1)>999999999999.99)
        {
           alert("Currency beyond Maximum limit ! Please re-enter");
           num.focus();
           num.select();
           return (0);
        }

        sign = (num1 == (num1 = Math.abs(num1)));
        num1 = Math.floor(num1*100+0.50000000001);
        cents = num1%100;
        num1 = Math.floor(num1/100).toString();
        if(cents<10)
            cents = "0" + cents;
        if(parseInt(num1)>999999999999.99)
        {
           alert("Currency beyond Maximum limit ! Please re-enter");
           num.focus();
           num.select();
           return (0);
        }
        return commaSplit((((sign)?'':'-') + num1 + '.' + cents),num);
    }
    else
    {
        return ("");
    }
}



function removeCommas(strVal)
{
alert("Start removeCommas() check");
  var strLength = strVal.length; 
  if (strLength == 0) return strVal;
  var strArr = new Array();
  strArr = strVal.split(",");
  var reqstring="";
  for(i=0;i<strArr.length;i++)
  {
	reqstring+= strArr[i];
  }	
  return reqstring;
}