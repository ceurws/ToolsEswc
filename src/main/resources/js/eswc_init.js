
function processPage(url)
{
	println("");
	println("*** START " + url);
	
	//rendering
	var srcConfig = {
			width: 1200,
			height: 800
	};
	srcConfig.url = url;
	proc.renderPage('FitLayout.CSSBox', srcConfig);

	//segmentation
	proc.initAreaTree('FitLayout.Grouping', {});
	//proc.apply('FitLayout.Segm.FindLines', {useConsistentStyle: false, maxLineEmSpace: 1.5});
	//proc.apply('FitLayout.Segm.HomogeneousLeaves', {});
	//proc.apply('FitLayout.Segm.SuperAreas', {depthLimit: 2});
	//proc.apply('Ceur.Tag.Class', {});
	proc.apply('FitLayout.Tag.Entities', {});
	proc.apply('Eswc.Tag.All', {});
	
	//logical tree
	proc.initLogicalTree('CEUR.Logical', {});
	
	//save the result
	saveCurrentPage();
	println("... DONE");
}

function saveCurrentPage()
{
	storage.saveBoxTree(proc.page);
	storage.saveAreaTree(proc.areaTree, proc.logicalAreaTree, proc.page.sourceURL);
}

storage.connect("http://localhost:8080/bigdata/sparql");
storage.clearDB();

println("ESWC init done.");

processPage('http://ceur-ws.org/Vol-1317/');
processPage('http://ceur-ws.org/Vol-1/');
/*processPage('http://ceur-ws.org/Vol-1128/');
processPage('http://ceur-ws.org/Vol-1123/');
processPage('http://ceur-ws.org/Vol-1116/');
processPage('http://ceur-ws.org/Vol-1111/');*/

println("processing done.");
