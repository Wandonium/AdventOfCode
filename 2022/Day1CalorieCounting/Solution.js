fetch('inputs2.txt')
  .then(response => response.text())
  .then(text => {
    console.log(text);
    const lines = text.split('\n');
    const totals = [];
    let currentTotal = 0;
    lines.forEach((line, idx) => {
        let lastIdx = lines.length - 1;
        if(parseInt(line)) {
            const num = parseInt(line);
            currentTotal += num;
            if(idx == lastIdx) {
                totals.push(currentTotal);
            }
        } else {
            totals.push(currentTotal);
            currentTotal = 0;
        }
    });
    totals.sort((a,b) => b - a);
    document.getElementById('largest').innerHTML = totals[0];
    document.getElementById('largest3').innerHTML = totals[2] + totals[1] + totals[0];
  });