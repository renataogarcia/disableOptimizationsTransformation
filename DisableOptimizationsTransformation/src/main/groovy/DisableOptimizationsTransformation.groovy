import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation


@GroovyASTTransformation(phase=CompilePhase.INSTRUCTION_SELECTION)
class DisableOptimizationsTransformation implements ASTTransformation{

	public void visit( ASTNode[] nodes, SourceUnit source ) {
		def config = source.getAST().getUnit().getConfig()
		config.getOptimizationOptions().put( "all", false )
	}

}
