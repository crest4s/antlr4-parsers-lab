// Generated from /Users/adrianmoralesrodriguez/Documents/Universidad/Procesadores del Lenguaje/compiladores-pl2/compiladores-pl2tof/PL2-Ubicua/src/main/antlr/IkeaLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IkeaLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IkeaLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#manual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManual(IkeaLangParser.ManualContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#itemHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemHeader(IkeaLangParser.ItemHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(IkeaLangParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#stepList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepList(IkeaLangParser.StepListContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(IkeaLangParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#unir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnir(IkeaLangParser.UnirContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#colocar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColocar(IkeaLangParser.ColocarContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#atornillar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtornillar(IkeaLangParser.AtornillarContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#conHerramienta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConHerramienta(IkeaLangParser.ConHerramientaContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#girar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGirar(IkeaLangParser.GirarContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#voltear}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoltear(IkeaLangParser.VoltearContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#repetir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetir(IkeaLangParser.RepetirContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#pieza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPieza(IkeaLangParser.PiezaContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#herramienta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHerramienta(IkeaLangParser.HerramientaContext ctx);
	/**
	 * Visit a parse tree produced by {@link IkeaLangParser#direccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDireccion(IkeaLangParser.DireccionContext ctx);
}