var nodes = new vis.DataSet([
  { id: 1, label: "Telefonica" },
  { id: 2, label: "Vodafone" },
  { id: 3, label: "Movistar" },
  { id: 4, label: "Miio" },
  { id: 5, label: "Telcel" },
  { id: 6, label: "Antena Aks" },
  { id: 7, label: "CLARO" },
  { id: 8, label: "c" },
  { id: 9, label: "Tuenti" },
  { id: 10, label: "CNT" },
  { id: 11, label: "N" },
]);

var edges = new vis.DataSet([
  { from: 1, to: 3, label: "3.25" },
  { from: 1, to: 5, label: "2.31" },
  { from: 2, to: 5, label: "4.23" },
  { from: 2, to: 4, label: "7.27" },
  { from: 2, to: 3, label: "5.34" },
  { from: 3, to: 4, label: "4.55" },
  { from: 3, to: 2, label: "5.34" },
  { from: 3, to: 1, label: "3.25" },
  { from: 3, to: 5, label: "4.59" },
  { from: 4, to: 3, label: "4.55" },
  { from: 4, to: 2, label: "7.27" },
  { from: 4, to: 5, label: "3.46" },
  { from: 4, to: 1, label: "4.74" },
  { from: 5, to: 3, label: "4.59" },
  { from: 5, to: 2, label: "4.23" },
  { from: 5, to: 1, label: "2.31" },
  { from: 5, to: 4, label: "3.46" },
  { from: 6, to: 5, label: "11.35" },
  { from: 6, to: 1, label: "9.18" },
  { from: 7, to: 4, label: "4.2" },
  { from: 7, to: 2, label: "3.16" },
  { from: 8, to: 4, label: "17473.96" },
  { from: 8, to: 2, label: "17475.87" },
  { from: 8, to: 6, label: "17484.88" },
  { from: 8, to: 7, label: "17475.59" },
  { from: 9, to: 1, label: "4.12" },
  { from: 9, to: 8, label: "17476.38" },
  { from: 9, to: 2, label: "6.69" },
  { from: 10, to: 1, label: "2.28" },
  { from: 10, to: 8, label: "17476.17" },
  { from: 10, to: 2, label: "4.84" },
  { from: 11, to: 1, label: "2.13" },
  { from: 11, to: 10, label: "3.71" },
]);

var container = document.getElementById("mynetwork");
      var data = {
        nodes: nodes,
        edges: edges,
      };
      var options = {};
      var network = new vis.Network(container, data, options);
