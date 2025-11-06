// Generated from /Users/adrianmoralesrodriguez/Documents/Universidad/Procesadores del Lenguaje/compiladores-pl2/compiladores-pl2tof/PL2-Ubicua/src/main/antlr/EPP.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EPPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EPPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EPPParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(EPPParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(EPPParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(EPPParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#mostrar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMostrar(EPPParser.MostrarContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#leer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeer(EPPParser.LeerContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#mientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMientras(EPPParser.MientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(EPPParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(EPPParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(EPPParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#comparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(EPPParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritmetica(EPPParser.AritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(EPPParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EPPParser#comentario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComentario(EPPParser.ComentarioContext ctx);
}