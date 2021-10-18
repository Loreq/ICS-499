var paintModule = angular.module('paintModule', []);


paintModule.controller('paintController',
    function makeGrid() {


        var gridHeight = 8;
        var gridWidth = gridHeight;

        var rowIndex, colIndex;

        var table = document.createElement("table");
        var tbody = document.createElement("tbody");


        for (rowIndex = 1; rowIndex <= gridHeight; rowIndex++) {

            var row = document.createElement("tr");

            for (colIndex = 1; colIndex <= gridWidth; colIndex++) {

                var col = document.createElement("td");
                if (rowIndex == 1 && colIndex == 1) {

                    col.style.backgroundColor = "red";
                    col.setAttribute("id", "finsih");

                } else if (rowIndex == gridHeight && colIndex == gridWidth) {
                    col.setAttribute("id", "start");

                } else {
                    col.setAttribute("id", "cell_" + rowIndex + "_" + colIndex);
                }
                row.appendChild(col);

            }

            tbody.appendChild(row);

        }

        table.appendChild(tbody);

        document.getElementById("grid_container").appendChild(table);


        var start = document.getElementById('start');
        start.focus();
        start.style.backgroundColor = 'limeGreen';


        function dotheneedful(sibling) {
            if (sibling != null) {
                start.focus();
                sibling.focus();
                sibling.style.backgroundColor = 'limeGreen';
                start = sibling;
            }
        }

        document.onkeydown = checkKey;

        function checkKey(e) {
            e = e || window.event;
            if (e.keyCode == '38') {
                // up arrow
                var idx = start.cellIndex;
                var nextrow = start.parentElement.previousElementSibling;
                if (nextrow != null) {
                    var sibling = nextrow.cells[idx];
                    dotheneedful(sibling);
                }
            } else if (e.keyCode == '40') {
                // down arrow
                var idx = start.cellIndex;
                var nextrow = start.parentElement.nextElementSibling;
                if (nextrow != null) {
                    var sibling = nextrow.cells[idx];
                    dotheneedful(sibling);
                }
            } else if (e.keyCode == '37') {
                // left arrow
                var sibling = start.previousElementSibling;
                dotheneedful(sibling);
            } else if (e.keyCode == '39') {
                // right arrow
                var sibling = start.nextElementSibling;
                dotheneedful(sibling);
            }
        }
    },

);

