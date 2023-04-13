function solution(data) {
    class Piece {
        constructor(piece, composer, key) {
            this.piece = piece;
            this.composer = composer;
            this.key = key;
        }
    }
    let numOfPieces = parseInt(data[0]);
    let pieces = [];
    for(let i = 1; i < 1+numOfPieces; i++) {
        let pieceInfo = data[i].split('|');
        let piece = new Piece(pieceInfo[0], pieceInfo[1], pieceInfo[2]);
        pieces.push(piece);
    }
    let commandIndex = 1+numOfPieces;
    let command = data[commandIndex];

    while(command !== 'Stop') {
        let commandInfo = command.split('|');
        switch(commandInfo[0]) {
            case 'Add': {let newPiece = new Piece(commandInfo[1], commandInfo[2], commandInfo[3]);
                        if(isPieceInTheCollection(commandInfo[1]) === -1) {
                            pieces.push(newPiece);
                            console.log(`${newPiece.piece} by ${newPiece.composer} in ${newPiece.key} added to the collection!`);
                        }
                        else console.log(`${newPiece.piece} is already in the collection!`);
                    }
            break;
            case 'Remove': { let piece = commandInfo[1];
                           let pieceinCollection = isPieceInTheCollection(piece);
                           if(pieceinCollection !== -1) {
                                pieces.splice(pieceinCollection, 1);
                                console.log(`Successfully removed ${piece}!`);
                           }
                           else console.log(`Invalid operation! ${piece} does not exist in the collection.`);
                        }
            break;
            case 'ChangeKey': {
                 let piece = commandInfo[1];
                 let pieceinCollection = isPieceInTheCollection(piece);
                 if(pieceinCollection === -1) {
                    console.log(`Invalid operation! ${piece} does not exist in the collection.`);
                    break;
                 }
                 let actualPiece = pieces[pieceinCollection];
                 actualPiece.key = commandInfo[2];
                 console.log(`Changed the key of ${piece} to ${commandInfo[2]}!`);
            }
            break;
        }
        command = data[++commandIndex];
    }

    pieces.forEach(piece => {
        console.log(`${piece.piece} -> Composer: ${piece.composer}, Key: ${piece.key}`);
    });



    f:function isPieceInTheCollection(piece) {
        let index = 0;
        for(let element of pieces) {
            if(element.piece== piece) return index;
            index++;
        }

        return -1;
    }

}

