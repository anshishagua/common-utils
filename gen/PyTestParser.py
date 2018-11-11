# Generated from /Users/lixiao/code/common-utils/src/main/resources/PyTest.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3")
        buf.write(u"\6\25\4\2\t\2\4\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\3")
        buf.write(u"\6\3\17\n\3\r\3\16\3\20\3\4\3\4\3\4\2\2\5\2\4\6\2\2\2")
        buf.write(u"\22\2\b\3\2\2\2\4\16\3\2\2\2\6\22\3\2\2\2\b\t\5\4\3\2")
        buf.write(u"\t\n\7\3\2\2\n\13\5\6\4\2\13\f\7\2\2\3\f\3\3\2\2\2\r")
        buf.write(u"\17\7\6\2\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2")
        buf.write(u"\20\21\3\2\2\2\21\5\3\2\2\2\22\23\7\4\2\2\23\7\3\2\2")
        buf.write(u"\2\3\20")
        return buf.getvalue()


class PyTestParser ( Parser ):

    grammarFileName = "PyTest.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ u"<INVALID>", u"'+'" ]

    symbolicNames = [ u"<INVALID>", u"PLUS", u"INTEGER", u"WS", u"LETTER" ]

    RULE_expr = 0
    RULE_id = 1
    RULE_int = 2

    ruleNames =  [ u"expr", u"id", u"int" ]

    EOF = Token.EOF
    PLUS=1
    INTEGER=2
    WS=3
    LETTER=4

    def __init__(self, input, output=sys.stdout):
        super(PyTestParser, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class ExprContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(PyTestParser.ExprContext, self).__init__(parent, invokingState)
            self.parser = parser

        def id(self):
            return self.getTypedRuleContext(PyTestParser.IdContext,0)


        def PLUS(self):
            return self.getToken(PyTestParser.PLUS, 0)

        def int(self):
            return self.getTypedRuleContext(PyTestParser.IntContext,0)


        def EOF(self):
            return self.getToken(PyTestParser.EOF, 0)

        def getRuleIndex(self):
            return PyTestParser.RULE_expr

        def enterRule(self, listener):
            if hasattr(listener, "enterExpr"):
                listener.enterExpr(self)

        def exitRule(self, listener):
            if hasattr(listener, "exitExpr"):
                listener.exitExpr(self)

        def accept(self, visitor):
            if hasattr(visitor, "visitExpr"):
                return visitor.visitExpr(self)
            else:
                return visitor.visitChildren(self)




    def expr(self):

        localctx = PyTestParser.ExprContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_expr)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 6
            self.id()
            self.state = 7
            self.match(PyTestParser.PLUS)
            self.state = 8
            self.int()
            self.state = 9
            self.match(PyTestParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class IdContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(PyTestParser.IdContext, self).__init__(parent, invokingState)
            self.parser = parser

        def LETTER(self, i=None):
            if i is None:
                return self.getTokens(PyTestParser.LETTER)
            else:
                return self.getToken(PyTestParser.LETTER, i)

        def getRuleIndex(self):
            return PyTestParser.RULE_id

        def enterRule(self, listener):
            if hasattr(listener, "enterId"):
                listener.enterId(self)

        def exitRule(self, listener):
            if hasattr(listener, "exitId"):
                listener.exitId(self)

        def accept(self, visitor):
            if hasattr(visitor, "visitId"):
                return visitor.visitId(self)
            else:
                return visitor.visitChildren(self)




    def id(self):

        localctx = PyTestParser.IdContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_id)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 12 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 11
                self.match(PyTestParser.LETTER)
                self.state = 14 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==PyTestParser.LETTER):
                    break

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class IntContext(ParserRuleContext):

        def __init__(self, parser, parent=None, invokingState=-1):
            super(PyTestParser.IntContext, self).__init__(parent, invokingState)
            self.parser = parser

        def INTEGER(self):
            return self.getToken(PyTestParser.INTEGER, 0)

        def getRuleIndex(self):
            return PyTestParser.RULE_int

        def enterRule(self, listener):
            if hasattr(listener, "enterInt"):
                listener.enterInt(self)

        def exitRule(self, listener):
            if hasattr(listener, "exitInt"):
                listener.exitInt(self)

        def accept(self, visitor):
            if hasattr(visitor, "visitInt"):
                return visitor.visitInt(self)
            else:
                return visitor.visitChildren(self)




    def int(self):

        localctx = PyTestParser.IntContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_int)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 16
            self.match(PyTestParser.INTEGER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





