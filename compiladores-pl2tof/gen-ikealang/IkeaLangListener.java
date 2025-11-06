// Generated from /Users/adrianmoralesrodriguez/Documents/Universidad/Procesadores del Lenguaje/compiladores-pl2/compiladores-pl2tof/PL2-Ubicua/src/main/antlr/IkeaLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IkeaLangParser}.
 */
public interface IkeaLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#manual}.
	 * @param ctx the parse tree
	 */
	void enterManual(IkeaLangParser.ManualContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#manual}.
	 * @param ctx the parse tree
	 */
	void exitManual(IkeaLangParser.ManualContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#itemHeader}.
	 * @param ctx the parse tree
	 */
	void enterItemHeader(IkeaLangParser.ItemHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#itemHeader}.
	 * @param ctx the parse tree
	 */
	void exitItemHeader(IkeaLangParser.ItemHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(IkeaLangParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(IkeaLangParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#stepList}.
	 * @param ctx the parse tree
	 */
	void enterStepList(IkeaLangParser.StepListContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#stepList}.
	 * @param ctx the parse tree
	 */
	void exitStepList(IkeaLangParser.StepListContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(IkeaLangParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(IkeaLangParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#unir}.
	 * @param ctx the parse tree
	 */
	void enterUnir(IkeaLangParser.UnirContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#unir}.
	 * @param ctx the parse tree
	 */
	void exitUnir(IkeaLangParser.UnirContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#colocar}.
	 * @param ctx the parse tree
	 */
	void enterColocar(IkeaLangParser.ColocarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#colocar}.
	 * @param ctx the parse tree
	 */
	void exitColocar(IkeaLangParser.ColocarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#atornillar}.
	 * @param ctx the parse tree
	 */
	void enterAtornillar(IkeaLangParser.AtornillarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#atornillar}.
	 * @param ctx the parse tree
	 */
	void exitAtornillar(IkeaLangParser.AtornillarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#conHerramienta}.
	 * @param ctx the parse tree
	 */
	void enterConHerramienta(IkeaLangParser.ConHerramientaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#conHerramienta}.
	 * @param ctx the parse tree
	 */
	void exitConHerramienta(IkeaLangParser.ConHerramientaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#girar}.
	 * @param ctx the parse tree
	 */
	void enterGirar(IkeaLangParser.GirarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#girar}.
	 * @param ctx the parse tree
	 */
	void exitGirar(IkeaLangParser.GirarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#voltear}.
	 * @param ctx the parse tree
	 */
	void enterVoltear(IkeaLangParser.VoltearContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#voltear}.
	 * @param ctx the parse tree
	 */
	void exitVoltear(IkeaLangParser.VoltearContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#repetir}.
	 * @param ctx the parse tree
	 */
	void enterRepetir(IkeaLangParser.RepetirContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#repetir}.
	 * @param ctx the parse tree
	 */
	void exitRepetir(IkeaLangParser.RepetirContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#pieza}.
	 * @param ctx the parse tree
	 */
	void enterPieza(IkeaLangParser.PiezaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#pieza}.
	 * @param ctx the parse tree
	 */
	void exitPieza(IkeaLangParser.PiezaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#herramienta}.
	 * @param ctx the parse tree
	 */
	void enterHerramienta(IkeaLangParser.HerramientaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#herramienta}.
	 * @param ctx the parse tree
	 */
	void exitHerramienta(IkeaLangParser.HerramientaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IkeaLangParser#direccion}.
	 * @param ctx the parse tree
	 */
	void enterDireccion(IkeaLangParser.DireccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IkeaLangParser#direccion}.
	 * @param ctx the parse tree
	 */
	void exitDireccion(IkeaLangParser.DireccionContext ctx);
}