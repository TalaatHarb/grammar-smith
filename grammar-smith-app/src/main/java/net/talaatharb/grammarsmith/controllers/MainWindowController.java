package net.talaatharb.grammarsmith.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.grammarsmith.utils.GUIUtils;

@Slf4j
@RequiredArgsConstructor
public class MainWindowController implements Initializable {

	private static final String CSS_FILE = "../ui/theme.css";

	@FXML
	private AnchorPane grammarEditorPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		log.info("Main window loaded");

		var codeAreaPane = setupCodeArea();

		grammarEditorPane.getChildren().add(codeAreaPane);
		GUIUtils.setAnchorAll(codeAreaPane, 5.0);

	}

	private Node setupCodeArea() {
		CodeArea codeArea = new CodeArea();

		codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
		codeArea.getStylesheets().add(getClass().getResource(CSS_FILE).toExternalForm());

		codeArea.replaceText(0, 0, "if x == 10");

		// Apply styles to specific parts of the text
		codeArea.setStyleClass(0, 2, "keyword"); // 'if'
		codeArea.setStyleClass(3, 4, "variable"); // 'x'
		codeArea.setStyleClass(5, 7, "operator"); // '=='
		codeArea.setStyleClass(8, 10, "literal"); // '10'

		return new VirtualizedScrollPane<>(codeArea);
	}

}
