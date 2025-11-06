// Generated from /Users/adrianmoralesrodriguez/Documents/Universidad/Procesadores del Lenguaje/compiladores-pl2/compiladores-pl2tof/PL2-Ubicua/src/main/antlr/EPP.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EPPParser}.
 */
public interface EPPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EPPParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(EPPParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(EPPParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(EPPParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(EPPParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(EPPParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(EPPParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#mostrar}.
	 * @param ctx the parse tree
	 */
	void enterMostrar(EPPParser.MostrarContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#mostrar}.
	 * @param ctx the parse tree
	 */
	void exitMostrar(EPPParser.MostrarContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#leer}.
	 * @param ctx the parse tree
	 */
	void enterLeer(EPPParser.LeerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#leer}.
	 * @param ctx the parse tree
	 */
	void exitLeer(EPPParser.LeerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#mientras}.
	 * @param ctx the parse tree
	 */
	void enterMientras(EPPParser.MientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#mientras}.
	 * @param ctx the parse tree
	 */
	void exitMientras(EPPParser.MientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(EPPParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(EPPParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(EPPParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(EPPParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(EPPParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(EPPParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(EPPParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(EPPParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterAritmetica(EPPParser.AritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitAritmetica(EPPParser.AritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(EPPParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(EPPParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EPPParser#comentario}.
	 * @param ctx the parse tree
	 */
	void enterComentario(EPPParser.ComentarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link EPPParser#comentario}.
	 * @param ctx the parse tree
	 */
	void exitComentario(EPPParser.ComentarioContext ctx);
}